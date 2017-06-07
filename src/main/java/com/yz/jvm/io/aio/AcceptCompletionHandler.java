package com.yz.jvm.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler
		implements
			CompletionHandler<AsynchronousChannel, AsyncTimeServerHandler> {

	@Override
	public void completed(AsynchronousChannel result,
			AsyncTimeServerHandler attachment) {
		//attachment.asynchronousServerSocketChannel.accept(attachment, handler);;
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
		// TODO Auto-generated method stub

	}

}
