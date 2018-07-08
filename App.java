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
	
     if(input.getContentRaw().substring(0, 5).equalsIgnoreCase(Reference.prefix + "snap")) {
     //DARSHAN INSERT YOUR MATH.RANDOM BS AND STUFF HERE MY DUDE
     
     }
    	
    	}
}
