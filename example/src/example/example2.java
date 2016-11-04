package example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.UserAuthenticator;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;

public class example2 {
	public static void main(String[] args) throws IOException {

	    String domain="centos";
	    String userName="centos";
	    String password="centos";
	    String remoteFilePath="////10.41.78.47/var/lib/logrotate.status";



	    File f=new File("\\\\log.txt"); //Takes the default path, else, you can specify the required path
	    if(f.exists())
	    {
	        f.delete();
	    }
	    f.createNewFile(); 
	    FileObject destn=VFS.getManager().resolveFile(f.getAbsolutePath());

	    //domain, username, password
	    UserAuthenticator auth=new StaticUserAuthenticator(domain, userName, password);
	    FileSystemOptions opts=new FileSystemOptions();
	    DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);


	    FileObject fo=VFS.getManager().resolveFile(remoteFilePath,opts);

	    System.out.println(fo.exists());

	    //fo.createFile();

	    destn.copyFrom(fo,Selectors.SELECT_SELF);
	    destn.close();

	    //InputStream is=new FileInputStream(f);

	}
}