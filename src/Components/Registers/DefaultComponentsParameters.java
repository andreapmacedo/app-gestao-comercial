package Components.Registers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public abstract class DefaultComponentsParameters extends JPanel {

    public BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();
    public GridBagConstraints c = new GridBagConstraints(); //Restriçoes

    public Dimension txfPreferedSize = (new Dimension(150, 20));
    public Dimension txfMinimumSize = txfPreferedSize;
    public Dimension txfMaximumSize = txfPreferedSize;
    
     public Dimension cmbPreferedSize = (new Dimension(150, 20));
    public Dimension cmbMinimumSize = cmbPreferedSize;
    public Dimension cmbMaximumSize = cmbPreferedSize;
    
    
    
    
    

    public DefaultComponentsParameters() {

        configPanel();
        configGridBagConstraints();
        configJCombobox();
        // podemos criar vários padroes de elementos (botoes, combobox, etc) com tamanho e configuações

    }

    private void configGridBagConstraints() {

        c.insets = new Insets(4, 4, 4, 4);
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;

//Default        
//anchor: CENTER
//fill: NONE
//gridx: RELATIVE
//gridy: RELATIVE
//gridheight: 1
//gridwidth: 1
//insets: Insets(0, 0, 0, 0)
//weightx: 0
//weighty: 0
//ipadx: 0
//ipady: 0 
    }

    private void configJCombobox() {
        //Alinhamento dafault do UIResource 
        UIResource.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void configPanel() {

        setLayout(new BorderLayout());
      //  setLayout(new GridBagLayout());
        //  setLayout(new FlowLayout((FlowLayout.LEFT), 10, 10));
        //  setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //setBorder(BorderFactory.createTitledBorder("Pesquisa"));

    }

}

//fill: Determina como redimensionar o componente. Valores possíveis para esta propriedade são:
//NONE: Não redimensiona o componente
//HORIZONTAL: Redimensiona horizontalmente, fazendo com que o mesmo ocupe toda a área horizontal na célula
//VERTICAL: Redimensiona verticalmente, fazendo com que o mesmo ocupe toda a área vertical na célula
//BOTH: Redimensiona para ambas as direções.
//Valor padrão é NONE
//anchor: Essa propriedade é utilizada somente quando o tamanho do componente é menor que a área que lhe foi concedida. 
//Normalmente, queremos que nosso componente ocupe toda a área disponível, mas em casos especiais, não podemos redimensionar os componentes. 
//Sendo assim, o layout precisa saber em que posição da célula deixará o componente. Os valores para esse campo são de dois tipos: 
//Absolutos (CENTER, NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, e NORTHWEST) e 
//Relativos (PAGE_START, PAGE_END, LINE_START, LINE_END, FIRST_LINE_START, FIRST_LINE_END, LAST_LINE_START and LAST_LINE_END). O valor padrão é CENTER. 
//gridx e gridy: Especificam a posição X,Y para adicionar o componente. 
//Não é necessário alterar seus valores, pois seu valor padrão é a constante RELATIVE
//e portanto o layout adicionará após o último componente que foi colocado.
//- gridx: Permite especificar qual a posição absoluta horizontalmente que o componente será adicionado.
//- gridy: Permite especificar qual a posição absoluta verticalmente que o componente será adicionado. 
//gridheight e gridwidth Especificam o tamanho do componente baseado em células.
//É com essa propriedade que você indicará que um componente seu ocupará duas células, ou ocupurá tantas quanto forem necessárias para ir até o final da tela. 
//Lembrem-se é células e não pixels
//Nestes valores podem ser utilizadas duas constantes: REMAINDER e RELATIVE. REMAINER fará com que o componente se estique até a última célula. 
//Já o RELATIVE fará com que o componente ocupe todas as casas com excessão da última.
//- gridheight: Especifica o número de células que o componente ocupará verticalmente. Valor padrão é 1.
//- gridwidth: Especifica o número de células que o componente ocupará horizontalmente. Valor padrão é 1. 
//insets: Indica as distãncias entre os componentes do lauout. Um Insets possui valores para as 4 direções, cima, baixo, direita e esquerda. 
//Permitindo com isso muita flexibilidade no gerenciador. Valor padrão é new Insets(0, 0, 0, 0) 
//ipadx e ipady Determina um adicional nas bordas internas do componenete. 
//Essa propriedade modifica o tamanho mínimo de cada componente. 
//O tamanho mínimo será o ipad + o valor mínimo do componente.
//- ipadx: Valor para ser adicionado horizontalmente.
//- ipady: Valor para ser adicionado verticalmente. 
//weight: Essas propriedades especificam um percentual de crescimento da célula, não do componente, quando a mesma precisa ser redimensionada.
//É dito isso, pois se o componente não pode se redimensionar, pois a propriedade fill do constraint afirma isso, o componente não vai sofrer as alterações, mas a célula irá aumentar.
//Com este layout é possível informar que uma célula redimensionará 75% e o outra 25%, portanto o primeiro componente receberá 3 vezes mais tamanho do que o segundo.
//O valor padrão é 0 e os valores percentuais são dados em casas decimais, por exemplo: 0.03 é igual a 3%, 1.00 é igual a 100% e por aí vai.
//- weightx: Peso em x. Especifica um peso no redimensionamento.
//Este peso será utilizado para um cálculo que o layout faz para determinar quais as células irão redimensionar horizontalmente, quais não irão, e quais aumentarão mais que os outros.
//- weighty: Peso em y. Especifica um peso no redimensionamento. 
//Este peso será utilizado para um cálculo que o layout faz para determinar quais as células irão redimensionar verticalmente, quais não irão, e quais aumentarão mais que os outros. 
//anchor: CENTER
//fill: NONE
//gridx: RELATIVE
//gridy: RELATIVE
//gridheight: 1
//gridwidth: 1
//insets: Insets(0, 0, 0, 0)
//weightx: 0
//weighty: 0
//ipadx: 0
//ipady: 0 
