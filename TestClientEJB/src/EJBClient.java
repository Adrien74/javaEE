import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.interfaces.*;
public class EJBClient {

  public static void main(String[] args) {
    try {
    	Context context = new InitialContext();
    	EJBInterface bean = (EJBInterface) context.lookup("EJB");
    	System.out.println(bean.getAllColis().toString());
    }catch(NamingException e){
    	e.printStackTrace();
    }
    
  }
}