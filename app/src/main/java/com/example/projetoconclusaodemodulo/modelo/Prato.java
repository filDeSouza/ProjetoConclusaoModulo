package com.example.projetoconclusaodemodulo.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

    private int imagem;
    private String nome;
    private String descricao;

    public Prato() {
    }

    public Prato(int imagem, String nome, String descricao) {
        this.imagem = imagem;
        this.nome = nome;
        this.descricao = descricao;
    }

    protected Prato(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
        descricao = in.readString();
    }

    public static final Creator<Prato> CREATOR = new Creator<Prato>() {
        @Override
        public Prato createFromParcel(Parcel in) {
            return new Prato(in);
        }

        @Override
        public Prato[] newArray(int size) {
            return new Prato[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
        dest.writeString(descricao);
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
