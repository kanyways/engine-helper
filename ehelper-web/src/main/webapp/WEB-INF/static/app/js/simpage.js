/**
 * 单页面路由
 *
 * @author kangyonggan
 * @since 2017/3/21
 */
(function ($) {
    /**
     * 获取内容的url
     *
     * @param hash
     * @returns {string}
     */
    function getContentUrl(hash) {
        return window.location.origin + window.location.pathname + hash
    }

    /**
     * 加载成功
     */
    function onSuccess() {
    }

    /**
     * 加载失败
     */
    function onError() {
    }

    /**
     * 总入口
     *
     * @param contentArea
     * @param settings
     */
    function simPage(contentArea, settings) {
        var $contentArea = $(contentArea);
        var $overlay = $();//empty set
        var loadingTimer;
        // 把settings的属性合并到defaults，并且不改变defaults
        settings = $.extend(true, $.fn.simPage.defaults, settings);
        /**
         * 开始加载
         */
        function startLoading() {
            // 清除定时器
            clearInterval(loadingTimer);
            $overlay.remove();
            $overlay = $('<div>' + settings.loadingText + '</div>').css({
                position: "absolute",
                left: 0,
                top: 0,
                bottom: 0,
                right: 0,
                zIndex: 9999,
                textAlign: "center",
                marginTop: "100px"
            }).addClass("sim-page-loading");
            $contentArea.append($overlay);
            var text = $overlay.html();
            var count = 0;
            // 定时输出正在加载...
            loadingTimer = setInterval(function () {
                var temp = ".";
                for (var i = 0; i < count; i++) {
                    temp += ".";
                }
                $overlay.html(text + temp);
                count++;
                count %= 3;
            }, 1000);
        }

        /**
         * 停止加载
         *
         * @param isSuccess
         */
        function stopLoading(isSuccess) {
            // 清除定时器
            clearInterval(loadingTimer);
            $overlay.remove();
            if (isSuccess) {
                onSuccess();
            } else {
                onError();
            }
        }

        /**
         * 加载url
         *
         * @param url
         * @param method
         * @param data
         */
        function getUrl(url, method, data) {
            if (!method) {
                method = "get";
            }

            // 开始加载
            startLoading();
            $.ajax({
                'url': url,
                'cache': false,
                "method": method,
                "data": data
            }).error(function () {
                // 停止加载
                stopLoading(false);
                getUrl(getContentUrl("404"));
            }).done(function (result) {
                // 停止加载
                stopLoading(true);
                // 内容替换
                $contentArea.empty().html(result);
                scroll(0,0)
            });
        }

        /**
         * 异步加载url
         *
         * @param hash
         * @param cache
         */
        function loadUrl(hash) {
            hash = hash.replace(/^(\#\!)?\#/, '');
            var url = settings.contentUrl(hash);
            if (typeof url === 'string') {
                getUrl(url);
            }
        };
        // 监听hash改变
        $(window).off('hashchange').on('hashchange', function (e, manual_trigger) {
            var hash = $.trim(window.location.hash);
            if (!hash || hash.length == 0) {
                return;
            }

            // 异步加载url
            loadUrl(hash);
        });
        // 是否使用默认URL
        var hash = $.trim(window.location.hash);
        if (!hash && settings.defaultUrl) {
            window.location.hash = settings.defaultUrl;
        }
        loadUrl(hash);
        // 相对定位，给【加载中...】使用
        $contentArea.css("position", "relative");

        // 监听表单提交
        $(document).on("submit", "form", function (e) {
            var $form = $(this);

            var hash = $form.attr("action");
            var method = $form.attr("method");

            if (hash.substring(0, 1) == "#") {
                e.preventDefault();
            } else {
                return true;
            }

            // 处理get方法
            if (method.toLowerCase() == "get") {
                var params = $form.serialize();
                var url = window.location.origin + window.location.pathname + hash + "?" + params;

                window.location.href = url;
            } else if (method.toLowerCase() == "post") {
                var url = window.location.origin + window.location.pathname + hash.substring(1);

                getUrl(url, "post", $form.serialize());
            }

            return false;
        });
    }

    /**
     * 单页面路由
     *
     * @param option
     * @returns {*}
     */
    $.fn.simPage = function (option) {
        return this.each(function () {
            $(this).data('simPage', new simPage(this, option));
        });
    };
    /**
     * 默认配置
     *
     * @type {{defaultUrl: string, contentUrl: getContentUrl, loadingText: string, success: onSuccess, error: onError}}
     */
    $.fn.simPage.defaults = {
        // 默认URL（默认index）
        defaultUrl: '#index',
        // 内容URL（一般默认即可）
        contentUrl: getContentUrl,
        // 加载中的文字
        loadingText: '正在加载',
        // success回调方法
        success: onSuccess,
        // error回调方法
        error: onError
    }
})(window.jQuery);