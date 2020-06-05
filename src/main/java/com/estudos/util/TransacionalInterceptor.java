package com.estudos.util;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor //diz p cdi que essa é a classe interceptadora
@Transacional //diz  pra o cdi que é pra ele interceptar as classes e metodos que tenha essa notação (@Transacional)
@Priority(Interceptor.Priority.APPLICATION) //ativa o interceptador com prioridade de apllicação.Essa configuração pode ser feita no benas.xml
public class TransacionalInterceptor {
	   private static final long serialVersionUID = 1L;

	    @Inject
	    private EntityManager manager;

	    @AroundInvoke
	    public Object invoke(InvocationContext context) throws Exception {
	        EntityTransaction trx = manager.getTransaction();
	        boolean criador = false;

	        try {
	            if (!trx.isActive()) {
	                // truque para fazer rollback no que já passou
	                // (senão, um futuro commit confirmaria até mesmo operações sem
	                // transação)
	                trx.begin();
	                trx.rollback();

	                // agora sim inicia a transação
	                trx.begin();

	                criador = true;
	            }

	            return context.proceed();
	        } catch (Exception e) {
	            if (trx != null && criador) {
	                trx.rollback();
	            }

	            throw e;
	        } finally {
	            if (trx != null && trx.isActive() && criador) {
	                trx.commit();
	            }
	        }
	    }

}
