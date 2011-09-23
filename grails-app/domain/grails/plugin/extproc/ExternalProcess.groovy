package grails.plugin.extproc

import java.util.List;
import java.util.Map;


/**
 * 
 * @author hennito (henne.lohse@gmail.com)
 * 
 * ExternalProcess domain class, that represents an external process.
 * 
 * name     - a unique identifyer of the process
 * isRemote - indicates whether it is a process on the local machine or a 
 * 			  process that needs to be invoked via webservice
 * exposedViaWS - indicates whether the process should be exposed as a webservice
 * 				  NOTE: currently a proces can be either remote or exposed, no forwarding is allowed
 * command -  if it is a local process, the executable file otherwise the the a string consisting of
 * 			  name@url where name is the name of the process on the other machine and url the 
 * 			  webservice endpoint
 * workDir  - the work directory of the process. Either a path on the filesystem or one 
 *            of the constants NO_WORKDIR or NEW_WORKDIR
 * timeout - for local processes, the time after which the process is cancelled in ms.
 * defaultParams - parameters added to the command
 * tokenPattern - if true, regular expression that the token passed via the input must match  
 *
 */
class ExternalProcess {

	static final String WORKDIR_PLACEHOLDER = '__WORKDIR__'
	static final String NEW_WORKDIR = '_CREATE_NEW_'
	static final String NO_WORKDIR = '_NO_WORKDIR_'
	
    static constraints = {
    	name nullable:false, minSize:2, unique:true
		isRemote nullable:false
		command blank:false
		workDir nullable:true
		timeout min:0L
		exposedViaWS nullable:false
		env nullable:true
		defaultParams nullable:true
		
		requiredFiles nullable:true
		
		allowedFilesPattern nullable:true
		allowedFiles nullable:true
		
		returnFilesPattern nullable:true
		returnFiles nuallable:true
		
		tokenPattern nullable:true
    }

	static hasMany = [
		allowedFiles:String,
		requiredFiles:String,
		returnFiles:String,
		defaultParams:String
	]
    String name
	Boolean isRemote = false
	Boolean exposedViaWS = false
	
	String tokenPattern
	
	String command
	List<String> defaultParams 
    String workDir = NEW_WORKDIR
	boolean cleanUpWorkDir = false
	boolean returnZippedDir = false
    
    Map<String, String> env = [:]
	String allowedFilesPattern
	List<String> allowedFiles = []
	List<String> requiredFiles = []
	String returnFilesPattern
	List<String> returnFiles = []

	Long timeout = 15000

	@Override
	public String toString() {
		return "ExternalProcess [name=" + name + ", isRemote=" + isRemote +
				 ", exposedViaWS=" + exposedViaWS + ", command=" + command +
				 ", defaultParams=" + defaultParams + ", workDir=" + workDir +
				 ", cleanUpWorkDir=" + cleanUpWorkDir + ", returnZippedDir=" +
				 returnZippedDir + ", env=" + env + ", allowedFiles=" +
				 allowedFiles + ", requiredFiles=" + requiredFiles +
				 ", returnFiles=" + returnFiles + ", timeout=" + timeout + "]";
	}

	
	
}
