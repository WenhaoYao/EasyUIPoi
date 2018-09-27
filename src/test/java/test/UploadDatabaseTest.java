package test;

import jxau.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

/**
 * @author YaoWenHao
 * @Title: UploadDatabaseTest
 * @ProjectName EasyuiJavaCrud
 * @Description: TODO
 * @date 2018/9/27 20:01
 */
public class UploadDatabaseTest {

    @Test
    public void uploadTest() throws Exception {
        Workbook workbook = ExcelUtil.getWorkBook("G:\\question_data\2018竞赛公开题库.xls");

    }

}
