package com.execel.parsedemo.execle;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.execel.parsedemo.execle.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class ExecleUtil {

    public static <T> List<T> importExecle(String  filePath, Integer titleRows, Integer headerRows, Class<User> pojoClass){

        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass){
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * @Desc
     * @param file
     * @param titleRows
     * @param headerRows
     * @param pojoClass
     * @param <T>
     * @return
     */
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass, IExcelDataHandler<T> handler){
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setDataHanlder(handler);
        List<T> successList=null;
        try {
            ExcelImportResult<T> result = ExcelImportUtil.importExcelMore(file.getInputStream(), pojoClass, params);
            successList=result.getList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return successList;
    }
}
