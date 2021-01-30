package storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import model.User;

public class DataStore implements Serializable {

	private static DataStore dataStore;
	private Map<String, User> bankData = new HashMap<>();
	private static final long serialVersionUID = 1L;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;

	private DataStore() throws ClassNotFoundException, IOException {
	}

	public static DataStore getInstance() {
		if(dataStore == null) {
			synchronized (dataStore) {
				if(dataStore == null) {
					try {
						dataStore = new DataStore();
					} catch (ClassNotFoundException | IOException e) {
						dataStore = null;
					}
				}
			}
		}

		return dataStore;
	}

	// Save Map objects to the file
	public void save(User obj) throws IOException {
		String key = obj.getAccountNumber() + "";
		bankData.put(key, obj);
		fos = new FileOutputStream("src\\storage\\BankData.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(bankData);
		if (oos != null)
			oos.close();
	}

	// Retrieve Map object from File
	@SuppressWarnings("unchecked")
	public User retrieveUser(String accountNo) throws IOException, ClassNotFoundException {
		Map<String, User> bankUserData = new HashMap<>();
		fis = new FileInputStream("src\\storage\\BankData.txt");
		ois = new ObjectInputStream(fis);
		if (ois != null)
			bankUserData = (HashMap<String, User>) ois.readObject();
		ois.close();
		return bankUserData.get(accountNo);
		
	}
}
