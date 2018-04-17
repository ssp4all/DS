/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Stateless;

/**
 *
 * @author ssp
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public int login(String uname, String pass) {
        if(uname.equals(pass))
            return 1;
        else
            return 0;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
