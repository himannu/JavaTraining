package com.simplilearn.la.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	private static StandardServiceRegistry registry;
	
		public static SessionFactory getSessionFactory() {
			if (factory != null) {
				factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
			
			try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                factory = metadata.getSessionFactoryBuilder().build();
	
            } catch (Exception e) {
                e.printStackTrace();
                
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
			return factory;
	}
		
	public static void shutdownFactory() {
		
		 if (registry != null) {
             StandardServiceRegistryBuilder.destroy(registry);
         }
		 
	}
		
}
