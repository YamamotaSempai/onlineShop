package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.model.property.*;
import kz.aa.shop.onlineShop.service.impl.CapServiceImpl;
import kz.aa.shop.onlineShop.service.impl.PropertyCapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Set;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private CapServiceImpl capService;
    @Autowired
    private PropertyCapServiceImpl propertyCapService;
    @Autowired
    private UtilImage utilImage;
    @Autowired
    private ApplicationContext applicationContext;

    private String uploadPath;

    @RequestMapping(value = "/admin/page", method = RequestMethod.GET)
    public String mainForAdmin(Model model,
                               @ModelAttribute("cap") Cap cap,
                               @ModelAttribute("propertyCap") PropertyCap propertyCap) throws IOException {


        Resource resource = applicationContext.getResource("easdasd");
        uploadPath = resource.getFile().getAbsolutePath();
        System.out.println(uploadPath);


        return "admin/page";
    }

    @RequestMapping(value = "/admin/createItem", method = RequestMethod.POST, headers = "content-type=multipart/*")
    public String createItem(@ModelAttribute("cap") Cap cap,
                             @ModelAttribute("propertyCap") PropertyCap propertyCap,
                             @ModelAttribute("color") ColorEnum colorEnum,
                             @ModelAttribute("gender") Gender gender,
                             @ModelAttribute("material") MaterialEnum materialEnum,
                             @ModelAttribute("size") Set<SizeEnum> sizeEnum,
                             @RequestParam("file") MultipartFile file
    ) throws IOException {

//        cap.setGenders(Collections.singleton(gender));
//        capService.saveOrUpdate(cap);
//
//        propertyCap.setCap(cap);
//        propertyCap.setColorEnum(colorEnum);
//        propertyCap.setMaterialEnum(materialEnum);
//        propertyCap.setSizeEnum(sizeEnum);
//
//        propertyCapService.saveOrUpdate(propertyCap);

        utilImage.saveFile(file,uploadPath);
        return "admin/page";
    }
}
