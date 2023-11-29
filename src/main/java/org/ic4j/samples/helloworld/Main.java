package org.ic4j.samples.helloworld;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

			Properties env = new Properties();
			env.load(propInputStream);

			String icLocation = env.getProperty("ic.location");
			String icCanister = env.getProperty("ic.canister");

			System.out.println("  >>>> LOCATION: " + icLocation);
			System.out.println("  >>>> CANISTER: " + icCanister);

			ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);
			Agent agent = new AgentBuilder().transport(transport).build();

			IcpNemooProxy nemooProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister)).getProxy(IcpNemooProxy.class);

			String value = "world";

			CompletableFuture<String> proxyResponse = nemooProxy.getCommand();
			String output = proxyResponse.get();

			System.out.println("EE");
			CompletableFuture<Fish> proxyResponseFish = nemooProxy.getFish("100");
			System.out.println("FF");

			Fish x = proxyResponseFish.get();

			System.out.println("OUT" + x.getFisher());
			System.out.println("OUT" + x.getId());
			System.out.println("OUT" + x.getWeight());
			System.out.println("OUT" + x.getHeight());

			x.setId(x.getId() + new Date().getTime());
			System.out.println(x.getId());

			CompletableFuture<String> proxySaveFish = nemooProxy.saveFish(x);

			System.out.println("GG");
			System.out.println(proxySaveFish.get());

			System.out.println("EE");
			CompletableFuture<Fisher> proxyResponseFisher = nemooProxy.getFisher("200");
			System.out.println("FF");

			Fisher fisher = proxyResponseFisher.get();

			System.out.println("OUT" + fisher.getId());
			System.out.println("OUT" + fisher.getName());
			System.out.println("OUT" + fisher.getCity());
			System.out.println("OUT" + fisher.getAge());

			fisher.setId(fisher.getId() + new Date().getTime());
			System.out.println(fisher.getId());

			CompletableFuture<String> proxySaveFisher = nemooProxy.saveFisher(fisher);

			System.out.println("GG");
			System.out.println(proxySaveFisher.get());

			LOG.info(output);

		} catch (Throwable e) {
			// LOG.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}

}
