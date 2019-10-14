package com.example.projetoconclusaodemodulo.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurante implements Parcelable {

    private int imagem;
    private String nome;
    private String endereco;
    private String horaAbertura;
    private String horaFechamento;

    public Restaurante() {
    }

    public Restaurante(int imagem, String nome, String endereco, String horaAbertura, String horaFechamento) {
        this.imagem = imagem;
        this.nome = nome;
        this.endereco = endereco;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    protected Restaurante(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
        endereco = in.readString();
        horaAbertura = in.readString();
        horaFechamento = in.readString();
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(horaAbertura);
        dest.writeString(horaFechamento);
    }
}
