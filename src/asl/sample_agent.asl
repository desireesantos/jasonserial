// Agent sample_agent in project protocolComunication

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("hello world.").

+pos(1)<- test;
		  .print("Mensagem Position 1").
		  
+pos(2)<- .print("Mensagem Position 2").