package Entidades.Aluno;

public class AvaliacaoFisica {
    private int altura;
    private float peso;
    private int[] circunferencias;
    private int[] pregasCutaneas;
    private float[] diametroOsseo;

    public AvaliacaoFisica(int altura, float peso, int[] circunferencias, int[] pregasCutaneas, float[] diametroOsseo) {
        this.altura = altura;
        this.peso = peso;
        this.circunferencias = circunferencias;
        this.pregasCutaneas = pregasCutaneas;
        this.diametroOsseo = diametroOsseo;
    }

    public float getAltura() {
        return this.altura;
    }

    public float getPeso() {
        return this.peso;
    }

    public int[] getCircunferencias() {
        return this.circunferencias;
    }

    public int[] getPregasCutaneas() {
        return this.pregasCutaneas;
    }

    public float[] getDiametroOsseo() {
        return this.diametroOsseo;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    } 

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setCircunferencias(int[] circunferencias) {
        this.circunferencias = circunferencias;
    }

    public void setPregasCutaneas(int[] pregasCutaneas) {
        this.pregasCutaneas = pregasCutaneas;
    }

    public void setDiametroOsseo(float[] diametroOsseo) {
        this.diametroOsseo = diametroOsseo;
    } 

}
