package service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.axis2.AxisFault;

import model.Client;
import model.Credit;
import service.CreditServiceStub.Annuite;
import service.CreditServiceStub.AnnuiteResponse;

import service.CreditServiceStub.Find;
import service.CreditServiceStub.FindResponse;
import service.CreditServiceStub.GetCreditsByUsername;
import service.CreditServiceStub.GetCreditsByUsernameResponse;

public class CreditServiceClientTest {

	public static void main(String[] args) throws RemoteException {
		try {
			/*CreditServiceStub css = new CreditServiceStub();
			Annuite annuite = new Annuite();
			annuite.setCapital(200000);
			annuite.setDuree(120);
			annuite.setT(0.05);
			AnnuiteResponse res = css.annuite(annuite);
			System.out.println("Anuuite:"+res.get_return()); */
			
			
			/*CreditServiceStub css = new CreditServiceStub();
			Find find = new Find();
			find.setPassword("amine");
			find.setUsername("amine");
			FindResponse res = css.find(find);
			Client cl = new Client();
			cl.setAdresse(res.get_return().getAdresse());
			cl.setNom(res.get_return().getNom());
			cl.setPrenom(res.get_return().getPrenom());
			cl.setMail(res.get_return().getMail());
			cl.setTel(res.get_return().getTel());
			cl.setUsername(res.get_return().getUsername());
			cl.setPassword(res.get_return().getPassword());
			cl.setVille(res.get_return().getVille());
			System.out.println(cl.toString());*/
			CreditServiceStub css = new CreditServiceStub();
			GetCreditsByUsername creditslist = new GetCreditsByUsername();
			creditslist.setUsername("amine");
			GetCreditsByUsernameResponse res = css.getCreditsByUsername(creditslist);
			service.CreditServiceStub.Credit[] clist = res.get_return();
			ArrayList<Credit> creditsarray = new ArrayList<>(); 
			for(int i=0;i<clist.length;i++) {
				creditsarray.add(new Credit(clist[i].getNumcredit(),clist[i].getDatecredit(),clist[i].getMontant(),clist[i].getDuree(),clist[i].getTaux(),clist[i].getAnnuite(),clist[i].getDateprever(),clist[i].getUsername()));
			}
			System.out.println(creditsarray);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
