package com.yz.jvm.zookeeper.queue;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;




import org.I0Itec.zkclient.ExceptionUtil;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;

public class DistributedSimpleQueue<T> {

	protected final ZkClient zkClient;
	protected final String root;

	protected static final String Node_NAME = "n_";


	public DistributedSimpleQueue(ZkClient zkClient, String root) {
		this.zkClient = zkClient;
		this.root = root;
	}

	public int size() {
		return zkClient.getChildren(root).size();
	}

	public boolean isEmpty() {
		return zkClient.getChildren(root).size() == 0;
	}
	
    public boolean offer(T element) {
    	
    	String nodeFullPath = root .concat( "/" ).concat( Node_NAME );
        try {
            zkClient.createPersistentSequential(nodeFullPath , element);
        }catch (ZkNoNodeException e) {
        	zkClient.createPersistent(root);
        	offer(element);
        } catch (Exception e) {
            throw ExceptionUtil.convertToRuntimeException(e);
        }
        return true;
    }


	@SuppressWarnings("unchecked")
	public T poll() throws Exception {
		
		try {

			List<String> list = zkClient.getChildren(root);
			if (list.size() == 0) {
				return null;
			}
			Collections.sort(list, new Comparator<String>() {
				public int compare(String lhs, String rhs) {
					return getNodeNumber(lhs, Node_NAME).compareTo(getNodeNumber(rhs, Node_NAME));
				}
			});
			
			for ( String nodeName : list ){
				
				String nodeFullPath = root.concat("/").concat(nodeName);	
				try {
					T node = zkClient.readData(nodeFullPath);
					zkClient.delete(nodeFullPath);
					return node;
				} catch (ZkNoNodeException e) {
					// ignore
				}
			}
			
			return null;
			
		} catch (Exception e) {
			throw ExceptionUtil.convertToRuntimeException(e);
		}

	}

	private String getNodeNumber(String str, String nodeName) {
		int index = str.lastIndexOf(nodeName);
		if (index >= 0) {
			index += Node_NAME.length();
			return index <= str.length() ? str.substring(index) : "";
		}
		return str;

	}

}
