package com.yz.jvm.thrift;

import com.yz.jvm.serialization.thrift.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer {
    public static void main(String[] args) {
        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(8899);
            THsHaServer.Args arg = new THsHaServer.Args(socket)
                    .maxWorkerThreads(8)
                    .minWorkerThreads(2);
            PersonService.Processor<PersonServiceImpl> processor =
                    new PersonService.Processor<>(new PersonServiceImpl());
            arg.protocolFactory(new TCompactProtocol.Factory());
            arg.transportFactory(new TFramedTransport.Factory());
            arg.processorFactory(new TProcessorFactory(processor));

            TServer server = new THsHaServer(arg);
            System.out.println("Thrift Service Started!!");

            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }
}
