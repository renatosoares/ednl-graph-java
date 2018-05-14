package graph;

import java.util.ArrayList;

class EulerianPath implements IEurelianPath
{
    private int degree;
    private int sum;
    private ArrayList[][] matrixAdjacent;
    private int numberLines;
    private int currentLine;

    public EulerianPath(ArrayList[][] m, int n)
    {
        this.degree = 0;
        this.sum = 0;
        this.matrixAdjacent = m;
        this.numberLines = n;
        this.currentLine = 0;
    }

    @Override
    public boolean hasPath()
    {
        while (this.sum <= 2 && this.currentLine < this.numberLines) {
            this.degree = 0;

            for (int column = 0; column < this.numberLines; column++) {

                if (this.matrixAdjacent[this.currentLine][column] != null) {
                    this.degree += this.matrixAdjacent[this.currentLine][column].size();
                }
            }


        System.out.println();
        System.out.print(this.degree);
            if (this.degree % 2 == 1) {
                this.sum++;
            }

            this.currentLine++;
        }

        System.out.println();
        System.out.print(this.sum);
        if (this.sum > 2) {
            return false;
        } else {
            return true;
        }
    }
}
