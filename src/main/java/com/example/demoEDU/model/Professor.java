package com.example.demoEDU.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Professor {

        @Id
        private int Cod;
        @Column
        private String nome;
        @Column
        private double salario;

        public int getCod() {
                return Cod;
        }

        public void setCod(int cod) {
                Cod = cod;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public double getSalario() {
                return salario;
        }

        public void setSalario(double salario) {
                this.salario = salario;
        }
}
