package bot.wintersentry;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter
{
	private static Command sentry;
    public static void main( String[] args ) throws Exception
    {

		JDA jda = new JDABuilder(AccountType.BOT).setToken(Reference.token).buildBlocking();
		sentry = new Command();
        jda.addEventListener(new App());
    }
    
    @Override 
    public void onMessageReceived(MessageReceivedEvent evt) {

    	//Objects
    	User user = evt.getAuthor();
    	MessageChannel output = evt.getChannel();
    	Message input = evt.getMessage();
    	
    	if(input.getContentRaw().equalsIgnoreCase(Reference.prefix + "commands")) {
    		
    		output.sendMessage(sentry.botCommands()).queue();
    	}
    	
    	//Hello, Goodbye
    	if(input.getContentRaw().equalsIgnoreCase(Reference.prefix + "hello")) {

			output.sendMessage(sentry.botHello()).queue();
			
    	}
    	
    	if(input.getContentRaw().equalsIgnoreCase(Reference.prefix + "goodbye")) {
    		
    		output.sendMessage(sentry.botGoodbye()).queue();
    	}
    	
    	//Roasts
    	if(input.getContentRaw().length() >= 6) {
	    	if(input.getContentRaw().substring(0,6).equalsIgnoreCase(Reference.prefix + "roast")) {
	    		if(input.getContentRaw().length() == 6) {
	    			output.sendMessage(sentry.roastCommands()).queue();
	    		}
	    		String str = input.getContentRaw().toLowerCase();
	    		String[] split = str.split(" ", 3);
	    			if(split.length == 3) {
	    				output.sendMessage(Character.toUpperCase(split[1].charAt(0)) + split[1].substring(1, split[1].length()) + ", " + sentry.botRoast(split[2], split)).queue();
	    			}
	    			else {
	    				
	    				output.sendMessage(Character.toUpperCase(split[1].charAt(0)) + split[1].substring(1, split[1].length()) + ", " + sentry.botRoast("0", split)).queue();
	    			}
	    	}
    	}
    	
    	//Dropper
    	if(input.getContentRaw().length() >= 4) {
    		if(input.getContentRaw().substring(0,4).equalsIgnoreCase(Reference.prefix + "ftn")) {
    			if(input.getContentRaw().length() == 4) {
	    			output.sendMessage(sentry.dropperCommands()).queue();
	    		}
				if(input.getContentRaw().substring(5).equalsIgnoreCase("pick")){
					output.sendMessage(sentry.chooseCommands()).queue();
				}
				
    			if(input.getContentRaw().substring(5).equalsIgnoreCase("drop")) {
    				output.sendMessage(sentry.botFortniteDropper()).queue();
    			}
    			
    			if(input.getContentRaw().substring(5,9).equalsIgnoreCase("pick") && !input.getContentRaw().contains("<")) { 
    				if(input.getContentRaw().length() != 8) {
	    				String str = input.getContentRaw().toLowerCase(); 
	    				String[] split = str.split(" ", 100);
	    					output.sendMessage(sentry.botFortniteChoose(split)).queue();
    				}

    			}
    			
    		}
    	}
    	
    	//Antarctica
    	if(input.getContentRaw().length() >= 7) {
	    	if(input.getContentRaw().substring(0, 7).equalsIgnoreCase(Reference.prefix + "access")) {
	    		if(input.getContentRaw().length() == 7) {
	    			output.sendMessage("+access <server> [Antarctica, Fieldtesting]").queue();
	    		}
	    		if(input.getContentRaw().substring(8).equalsIgnoreCase("antarctica")) {
	    			output.sendMessage("https://discord.gg/T7GTqxF").queue();
	    		}
	    		else if(input.getContentRaw().substring(8).equalsIgnoreCase("fieldtesting")) {
	    			output.sendMessage("https://discord.gg/2vbwnrx").queue();
	    		}
	    	}
    	}
    	
    	//Players
    	if(input.getContentRaw().length() >= 8) {
	    	if(input.getContentRaw().substring(0, 8).equalsIgnoreCase(Reference.prefix + "profile")) {
	    		if(input.getContentRaw().length() == 8) {
	    			
	    			output.sendMessage(sentry.profileCommands()).queue();
	    		}
	    		
	    		output.sendMessage(sentry.profile(input.getContentRaw().substring(9))).queue();
	    	}
    	}
    	//Image
    	if(input.getContentRaw().length() >= 4) {
	    	if(input.getContentRaw().substring(0, 4).equalsIgnoreCase(Reference.prefix + "img")) {
	    		if(input.getContentRaw().length() == 4) {
	    			
	    			output.sendMessage(sentry.imageCommands()).queue();
	    			
	    			
	    		}
	    		
	    		output.sendMessage(sentry.botImage(input.getContentRaw().substring(5))).queue();
	    		
	    	}
    	}
    	//Spam
        if(input.getContentRaw().length() >= 5) {
        	if(input.getContentRaw().substring(0, 5).equalsIgnoreCase(Reference.prefix + "spam")) {
        		if(input.getContentRaw().length() == 5) {
        			
        			output.sendMessage("+spam <sentence>").queue();
        		}
        		if(!input.getContentRaw().substring(6).equals("<sentence>") && (!input.getContentRaw().substring(6).contains("+"))){
        			
	        		for(int i = 0; i < 5; i++) {
	        			output.sendMessage(sentry.botSpam(input.getContentRaw().substring(6))).queue();
	        		}
        		}
        	}
        }
        
        
    }
     
}
    
