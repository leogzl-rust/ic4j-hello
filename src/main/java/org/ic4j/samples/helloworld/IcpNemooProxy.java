package org.ic4j.samples.helloworld;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.QUERY;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Waiter;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public interface IcpNemooProxy {

	@QUERY
	@Name("get_command")
	@Waiter(timeout = 30)
	public CompletableFuture<String> getCommand();

	@QUERY
	@Name("get_fish")
	@Waiter(timeout = 30)
	public CompletableFuture<Fish> getFish(@Argument(Type.TEXT) String name);

	@UPDATE
	@Name("save_fish")
	@Waiter(timeout = 30)
	public CompletableFuture<String> saveFish(@Argument(Type.RECORD) Fish fishArg);

	@QUERY
	@Name("get_fisher")
	@Waiter(timeout = 30)
	public CompletableFuture<Fisher> getFisher(@Argument(Type.TEXT) String name);

	@UPDATE
	@Name("save_fisher")
	@Waiter(timeout = 30)
	public CompletableFuture<String> saveFisher(@Argument(Type.RECORD) Fisher fisherArg);
}
