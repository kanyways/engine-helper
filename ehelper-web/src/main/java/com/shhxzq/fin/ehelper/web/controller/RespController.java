package com.shhxzq.fin.ehelper.web.controller;

import com.shhxzq.fin.ehelper.biz.util.PropertiesUtil;
import com.shhxzq.fin.ehelper.common.Excel;
import com.shhxzq.fin.ehelper.model.constants.AppConstants;
import com.shhxzq.fin.ehelper.web.util.FileUpload;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/26/17
 */
@Controller
@RequestMapping("resp")
@Log4j2
public class RespController extends BaseController {

    /**
     * 错误码首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return getPathIndex();
    }

    /**
     * 生成错误码SQL
     *
     * @param bankNo
     * @param excel
     * @return
     * @throws FileUploadException
     */
    @RequestMapping(value = "trans", method = RequestMethod.POST)
    @ResponseBody
    public String trans(@RequestParam("bankNo") String bankNo,
                        @RequestParam("excel") MultipartFile excel) throws FileUploadException {
        String fileName = FileUpload.upload(excel);
        log.info("错误码文件存储路径:{}", fileName);

        String path = PropertiesUtil.getProperties(AppConstants.FILE_PATH_ROOT) + fileName;
        List<String[]> list;
        try {
            list = Excel.excelToList(path, 2);
            log.info("一共{}条记录", list.size());
        } catch (Exception e) {
            return "解析Excel异常" + e.getMessage();
        }

        if (list.isEmpty()) {
            return "excel中没有数据";
        }

        StringBuilder sql = new StringBuilder("INSERT INTO be_resp \n\t(bnk_no, bnk_resp_co, bnk_resp_msg, mer_resp_co, mer_resp_msg, tran_st, c_man, e_man, status)\nVALUES");
        try {
            list.forEach(row -> {
                String tranSt = row[3];
                String merRespCo = "059999";
                if (tranSt.equals("Y")) {
                    merRespCo = "050000";
                } else if (tranSt.equals("I") || tranSt.equals("E")) {
                    merRespCo = "059998";
                }
                sql.append("\n\t('").append(bankNo).append("', '").append(row[0]).append("', '").append(row[1]).append("', '").append(row[2]).append("', '").append(merRespCo).append("', '").append(tranSt).append("', '', '', 'Y'),");
            });
        } catch (Exception e) {
            return "excel数据不合法";
        }
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(";");

        log.info("最终生成的SQL:{}", sql);
        return sql.toString();
    }

}
