package com.nocl.studentmanager.view;

import com.alee.api.resource.ClassResource;
import com.alee.api.resource.Resource;
import com.alee.managers.style.XmlSkin;
import com.alee.skin.light.WebLightSkin;

public class LoginSkin extends XmlSkin {
    public LoginSkin() {
        super(new ClassResource(LoginSkin.class, "../resources/skin.xml"));
    }
}
