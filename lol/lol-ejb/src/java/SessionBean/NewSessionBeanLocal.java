/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Local;

/**
 *
 * @author ssp
 */
@Local
public interface NewSessionBeanLocal {
        int login(String uname, String pass);

}
