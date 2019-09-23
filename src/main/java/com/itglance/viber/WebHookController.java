package com.itglance.viber
        ;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webhook")
public class WebHookController {

    private AuthenticationService authenticationService;

    private MessagingService messagingService;

    @Autowired
    public WebHookController(AuthenticationService authenticationService, MessagingService messagingService){
        this.authenticationService = authenticationService;
        this.messagingService = messagingService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String webhook(@RequestBody String obj){

        try {

            if(JSONUtils.parse(obj,"event").equals("message")){
                System.out.println(obj);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "Saved";
    }
}
