package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ReportService {
    @Autowired
    private CustomerRepository repository;


    public String exportReport(String reportFormat) throws FileNotFoundException, JRException,Exception {
       // String path = "D:\\Reports";
    	 String path = "C:\\Users\\USER\\Downloads\\demo\\src\\main\\resources";
        List<Customer> customers = repository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:Customer.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customers);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "hameed");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\customer.html");
            //byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\customer.pdf");
           // byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        }


        return "report generated in path : " + path;
/*        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
		res.getOutputStream().write(contentOf(file));*/

        //return bytes;

    }
	public void downloadFile(String fileName, HttpServletResponse res) throws Exception {
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		res.getOutputStream().write(contentOf(fileName));
	}
	private byte[] contentOf(String fileName) throws Exception {
		return Files.readAllBytes( Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
	}

    

}
