package br.com.mobicare.ga;

import org.springframework.util.LinkedMultiValueMap;

public class HitRequest extends LinkedMultiValueMap<String, String> {

    // Geral
    public void setV(String v) {
        this.add("v", v);
    }

    public void setTid(String tid) {
        this.add("tid", tid);
    }

    public void setAip(String aip) {
        this.add("aip", aip);
    }

    public void setDs(String ds) {
        this.add("ds", ds);
    }

    public void setQt(String qt) {
        this.add("qt", qt);
    }

    //Usuario
    public void setCid(String cid) {
        this.add("cid", cid);
    }

    public void setUid(String uid) {
        this.add("uid", uid);
    }

    //Sessao
    public void setSc(String sc) {
        this.add("sc", sc);
    }

    public void setUip(String uip) {
        this.add("uip", uip);
    }

    public void setUa(String ua) {
        this.add("ua", ua);
    }

    public void setGeoid(String geoid) {
        this.add("geoid", geoid);
    }

    //Origem do trafego
    public void setCn(String cn) {
        this.add("cn", cn);
    }

    public void setCs(String cs) {
        this.add("cs", cs);
    }

    public void setCm(String cm) {
        this.add("cm", cm);
    }

    public void setCk(String ck) {
        this.add("ck", ck);
    }

    public void setCc(String cc) {
        this.add("cc", cc);
    }

    public void setCi(String ci) {
        this.add("ci", ci);
    }

    public void setGclid(String gclid) {
        this.add("gclid", gclid);
    }

    public void setDclid(String dclid) {
        this.add("dclid", dclid);
    }

    //Informacoes do Sistema
    public void setSr(String sr) {
        this.add("sr", sr);
    }

    public void setVp(String vp) {
        this.add("vp", vp);
    }

    public void setDe(String de) {
        this.add("de", de);
    }

    public void setSd(String sd) {
        this.add("sd", sd);
    }

    public void setUl(String ul) {
        this.add("ul", ul);
    }

    public void setJe(String je) {
        this.add("je", je);
    }

    public void setFl(String fl) {
        this.add("fl", fl);
    }

    //Hit
    public void setT(String t) {
        this.add("t", t);
    }

    public void setNi(String ni) {
        this.add("ni", ni);
    }

    //Informacoes do conteudo
    public void setDp(String dp) {
        this.add("dp", dp);
    }

    public void setDt(String dt) {
        this.add("dt", dt);
    }

    //Acompanhamento de aplicativos
    public void setAn(String an) {
        this.add("an", an);
    }

    public void setAid(String aid) {
        this.add("aid", aid);
    }

    public void setAv(String av) {
        this.add("av", av);
    }

    public void setAiid(String aiid) {
        this.add("aiid", aiid);
    }
}
