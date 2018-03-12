package bg.framework.app.functional.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import bg.framework.app.functional.entities.UserProfile;

/**
 * Created by IntelliJ IDEA. User: !jithendb Date: 06/02/12 Time: 13:08 To
 * change this template use File | Settings | File Templates.
 */
public class RunQTP {
	public void runQTP(String vbsFile, String accNumber) {
		// public void runQTP(String vbsFile) {
		try {
			Process p = Runtime.getRuntime().exec(
					"cscript.exe //NoLogo ../" + vbsFile + " " + accNumber);
			// Process p = Runtime.getRuntime().exec("cscript.exe //NoLogo ../"
			// + vbsFile);
			p.waitFor();
			InputStream is = p.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			is.close();
			input.close();
		} catch (Exception i) {
			System.err.println("" + i.toString());
		}

	}

	public void runQTP1(String vbsFile, UserProfile profile) {

		try {

			String value = " " + profile.getInitialSoStatus();
			if (profile.getElecAccount().isEmpty()
					&& profile.getGasAccount().isEmpty()) {
				value += " Yes " + profile.getAccNumber() + " "
						+ profile.getAccNumber();
			} else {
				value += " No ";
				if (!profile.getElecAccount().isEmpty()
						&& profile.getGasAccount().isEmpty()) {
					value += profile.getElecAccount() + " 0";
				} else if (profile.getElecAccount().isEmpty()
						&& !profile.getGasAccount().isEmpty()) {
					value += profile.getGasAccount() + " 0";
				} else {
					value += profile.getGasAccount() + " "
							+ profile.getElecAccount();
				}
			}

			Process p = Runtime.getRuntime().exec(
					"cscript.exe //NoLogo ../" + vbsFile + value);
			p.waitFor();
			InputStream is = p.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			is.close();
			input.close();
		} catch (Exception i) {
			System.err.println("" + i.toString());
		}

	}

	public void runQTP1(String vbsFile) {

		try {

			Process p = Runtime.getRuntime().exec(
					"cscript.exe //NoLogo ../" + vbsFile);
			p.waitFor();
			InputStream is = p.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			is.close();
			input.close();
		} catch (Exception i) {
			System.err.println("" + i.toString());
		}

	}
}
