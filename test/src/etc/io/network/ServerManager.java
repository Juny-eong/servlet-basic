//package etc.io.network;
//
//import java.net.InetSocketAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Vector;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ServerManager {
//
//	private ExecutorService executorService;
//	private ServerSocket serverSocket;
//	private List<Client> connections = new Vector<>();
//
//
//	public void startServer() {
//		this.executorService = Executors.newFixedThreadPool(
//			Runtime.getRuntime().availableProcessors()
//		);
//
//		try {
//			serverSocket = new ServerSocket();
//			serverSocket.bind(  new InetSocketAddress("localhost", 5001)  );
//		}
//		catch (Exception e) {
//			if (!serverSocket.isClosed()) {
//				stopServer();
//			}
//			return;
//		}
//
//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						Socket socket = serverSocket.accept();
//
//						String message = "[ServerManager-" + Thread.currentThread().getName()
//									+ "] - connecting from ... [" + socket.getRemoteSocketAddress() + "]";
//
//						Client client = new Client(socket);
//						connections.add(client);
//					}
//					catch(Exception e) {
//						if (!serverSocket.isClosed()) {
//							stopServer();
//						}
//						break;
//					}
//				}
//
//			}
//		};
//		executorService.submit(runnable);
//	}
//
//
//	public void stopServer() {
//
//		try {
//			Iterator<Client> iterator = connections.iterator();
//			while (iterator.hasNext()) {
//				Client client = iterator.next();
//				client.socket.close();
//				iterator.remove();
//			}
//
//			if (serverSocket != null && !serverSocket.isClosed()) {
//				serverSocket.close();
//			}
//
//			if (executorService != null && )
//		}
//		catch(Exception e) {
//
//		}
//	}
//
//}
