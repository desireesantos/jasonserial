
import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import jssc.SerialPortList;

public class Protocol extends Environment {

 private Logger logger = Logger.getLogger("protocol_integration.mas2j."+ Protocol.class.getName());
 private SerialCommunication serialCom = new SerialCommunication();
	
	  /** constant terms used for perception */
 private static final Literal lPos1  = ASSyntax.createLiteral("pos", ASSyntax.createNumber(1));
 private static final Literal lPos2  = ASSyntax.createLiteral("pos", ASSyntax.createNumber(2));	
	
	public Protocol() {
		createPerception();
	}
	
	private void createPerception() {     
     addPercept(lPos1);
	}

 @Override
 public boolean executeAction(String agName, Structure action) {
     logger.info("executing: " + action);
     
    System.out.println(serialCom.msg()); 
	if (action.getFunctor().equals("test")) {
          addPercept(lPos2);     
     } 
     return true;
 }

 /** Called before the end of MAS execution */
 @Override
 public void stop() {
     super.stop();
 }
}

