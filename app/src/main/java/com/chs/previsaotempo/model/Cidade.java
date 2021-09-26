package com.chs.previsaotempo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cidade implements Parcelable {
    private int id;
    private String cidade;
    private String temperatura;
    private String temperaturaMax;
    private String temperaturaMin;
    private String latitude;
    private String longitude;
    private String velVento;
    private String visibilidade;
    private String humidade;
    private String pressaoAtmosferica;
    private Integer tipo;
    private String adicionado;


    public Cidade(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(String temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public String getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(String temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getVelVento() {
        return velVento;
    }

    public void setVelVento(String velVento) {
        this.velVento = velVento;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getHumidade() {
        return humidade;
    }

    public void setHumidade(String humidade) {
        this.humidade = humidade;
    }

    public String getPressaoAtmosferica() {
        return pressaoAtmosferica;
    }

    public void setPressaoAtmosferica(String pressaoAtmosferica) {
        this.pressaoAtmosferica = pressaoAtmosferica;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getAdicionado() {
        return adicionado;
    }

    public void setAdicionado(String adicionado) {
        this.adicionado = adicionado;
    }

    public static Creator<Cidade> getCREATOR() {
        return CREATOR;
    }

    public Cidade(Parcel in) {
        id = in.readInt();
        cidade = in.readString();
        temperatura = in.readString();
        temperaturaMax = in.readString();
        temperaturaMin = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        velVento = in.readString();
        visibilidade = in.readString();
        humidade = in.readString();
        pressaoAtmosferica = in.readString();
        tipo = in.readInt();
        adicionado = in.readString();
    }

    public static final Creator<Cidade> CREATOR = new Creator<Cidade>() {
        @Override
        public Cidade createFromParcel(Parcel in) {
            return new Cidade(in);
        }

        @Override
        public Cidade[] newArray(int size) {
            return new Cidade[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cidade);
        dest.writeString(temperatura);
        dest.writeString(temperaturaMax);
        dest.writeString(temperaturaMin);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(velVento);
        dest.writeString(visibilidade);
        dest.writeString(humidade);
        dest.writeString(pressaoAtmosferica);
        dest.writeInt(tipo);
        dest.writeString(adicionado);
    }
}
