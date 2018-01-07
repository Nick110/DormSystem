package dorm.system.controller;

import com.sun.rowset.internal.Row;
import dorm.system.dto.HygieneDto;
import dorm.system.dto.StaffDto;
import dorm.system.service.HygienegradesService;
import dorm.system.util.ExcelUtil;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExportExcelController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    HygienegradesService hygienegradesService;

    @RequestMapping(value="/downloadExcel")
    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String fileName = "excel文件";
        //填充projects数据
        List<HygieneDto> hygieneDtoList = createData();
        List<Map<String,Object>> list=createExcelRecord(hygieneDtoList);
        String columnNames[]={"序号", "公寓", "寝室号", "时间", "分数"};//列名
        String keys[]	=	 {"no", "aptName", "roomNo", "yearAndMonth", "remarks"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
    private List<HygieneDto> createData() {
        // TODO Auto-generated method stub
        //自己实现
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        List<HygieneDto> hygieneDtoList = hygienegradesService.seeHygiene(staffDto);
        return hygieneDtoList;
    }
    private List<Map<String, Object>> createExcelRecord(List<HygieneDto> hygieneDtoList) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        String aptName = hygienegradesService.selectAptName(staffDto);
        map.put("sheetName", "sheet1");
        listmap.add(map);
        HygieneDto hygieneDto = null;
        for (int j = 0; j < hygieneDtoList.size(); j++) {
            hygieneDto = hygieneDtoList.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("roomNo", hygieneDto.getRoomNo());
            mapValue.put("yearAndMonth", hygieneDto.getYearAndMonth());
            mapValue.put("remarks", hygieneDto.getRemarks());
            mapValue.put("no", j);
            mapValue.put("aptName", aptName);
            listmap.add(mapValue);
        }
        return listmap;
    }
}
