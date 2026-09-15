package dao;

import java.io.File;
import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				URL configResource = HibernateUtil.class.getClassLoader().getResource("hibernate.cfg.xml");
				if (configResource != null) {
					registryBuilder.configure(configResource);
				} else {
					File configFile = new File("src/hibernate.cfg.xml");
					if (!configFile.isFile()) {
						throw new RuntimeException("No se encontro hibernate.cfg.xml en el classpath ni en src/");
					}
					registryBuilder.configure(configFile);
				}
				StandardServiceRegistry standardRegistry = registryBuilder.build();
				MetadataSources metadataSources = new MetadataSources(standardRegistry);
				for (String mapping : new String[] {
						"Empleado.hbm.xml", "Plato.hbm.xml", "Pedido.hbm.xml",
						"ItemPedido.hbm.xml", "UnidadVenta.hbm.xml", "Festival.hbm.xml" }) {
					String resource = "mapeos/" + mapping;
					if (HibernateUtil.class.getClassLoader().getResource(resource) != null) {
						metadataSources.addResource(resource);
					} else {
						metadataSources.addFile(new File("src/" + resource));
					}
				}
				Metadata metaData = metadataSources.getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error inicializando Hibernate", e);
		}
	}
	
}