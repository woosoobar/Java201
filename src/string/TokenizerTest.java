package string;

import java.util.StringTokenizer;

public class TokenizerTest {

	public static void main(String[] args) {
		String msg = "[<MSGSIZE>( 116)][<Command>(LOGINUSER)][<Userid>(_mmcx_)][<Passwd>(_mmcx_)][<Ip>(10.10.105.127)][<Hostname>(harksoo-pc)][<Mac>(NONE)]";
		String receive = "[<MSGSIZE>( 169)][<Command>(ITRSTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(SYS_RESOURCE1)][<ITEM-NUM>(6)][<DATA>(10.80,8.96,17.53,17.51,42.99,42.99)]"
						+ "[<MSGSIZE>( 169)][<Command>(ITRSTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(SYS_RESOURCE2)][<ITEM-NUM>(6)][<DATA>(10.80,8.96,17.53,17.51,42.99,42.99)]"
						+ "[<MSGSIZE>( 155)][<Command>(REALTIMESTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(QUEUE_NUM)][<ITEM-NUM>(4)][<DATA>(0.00,0.00,0.00,0.00)]"
						+ "[<MSGSIZE>( 155)][<Command>(REALTIMESTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(ALARM_CNT)][<ITEM-NUM>(4)][<DATA>(0.00,0.00,0.00,0.00)]"
						+ "[<MSGSIZE>( 137)][<Command>(REALTIMESTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(----------)][<ITEM-NUM>(0)][<DATA>()]"
						+ "[<MSGSIZE>( 170)][<Command>(REALTIMESTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(SYSTEM_RSC)][<ITEM-NUM>(6)][<DATA>(10.80,7.12,7.12,17.53,17.50,17.50)]"
						+ "[<MSGSIZE>( 141)][<Command>(REALTIMESTAT)][<System>(OMP3)][<PERIOD>(10SEC)][<TIME>(2015-10-16-14:03:30)][<CATEGORY>(STAT_TEST)][<ITEM-NUM>(1)][<DATA>(90.91)]";

		String msg2 = "[<MSGSIZE>( 499)][<Command>(CONSOLE)][<RetVal>(SEOCHO 2015-10-22 19:11:01 THU ON SBCOMP"
			+"W2000 STATISTICS DATA WARNING DETECTED"
			+"  CATEGORY          = SYSTEM_CPU0000000000075"
			+"  SUBJECT           = System CPU Resource"
			+"  ALARM NAME        = SYSTEM_CPU0000000000075"
			+"  VAR[ 0]           = SFRSC:SYS_CPU_AVR(16.20)"
			+"  EXPRESSION FORM   = (VAR[0]<THR[0])"
			+"  EXPRESSION RESULT = (16.20<90.00)"
			+"  EXPRESSION MESSAGE"
			+"  System CPU Usage Statistic"
			+"COMPLETED"
			+""
			+")][<Param>(YELLOW)][<System>(SBC1A)][<GroupName>(MPGRP)][<First_flag>(1)]";
			
//		StringTokenizer st1 = new StringTokenizer(msg2, "<");
//		while ( st1.hasMoreTokens() ) {
//			String token = st1.nextToken();
//			System.out.println("token: " + token);
//			int keyEnd = token.indexOf(">");			
//			int valueBegin = token.indexOf("(")+1;
//			int valueEnd = token.indexOf(")");
//			System.out.println("valueEnd: " + valueEnd);
//			if ("MSGSIZE".equals(token.substring(0, keyEnd))) {
//				System.out.println("---------------------------------");
//			}
//			System.out.print("key: " + token.substring(0, keyEnd).trim());
//			System.out.println(", value: " + token.substring(valueBegin, valueEnd).trim());
////			System.out.println(token);
//			
//		}
	}
}
