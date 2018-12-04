package koreatech.cse.controller;


import koreatech.cse.service.DaoService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;


@Controller
@RequestMapping("/")
public class DaoController {

    @Inject
    private DaoService daoService;

    @Transactional
    @RequestMapping(value = "/getChampion", method = RequestMethod.GET)
    public String getChampion(Model model, @RequestParam(required=false) String id) {
        daoService.getChampionDAO(Integer.parseInt(id));
        return "lolStaticTest"; // 수정하도록!!***************************************
    }

    @Transactional
    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    public String getItem(Model model, @RequestParam(required=false) String id) {
        daoService.getItemDAO(Integer.parseInt(id));
        return "lolStaticTest"; // 수정하도록!!***************************************
    }
}
