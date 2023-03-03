### Escuela Colombiana de Ingeniería

### Procesos de Desarrollo de Software

### Desarrollo Dirigido por Pruebas + DIP + DI + Contenedores Livianos


Para este taller se va a trabajar sobre el juego del ahorcado.

El sistema actual de puntuación del juego comienza en 100 puntos y va
descontando 10 puntos cada vez que se propone una letra incorrecta.

Algunos usuarios han propuesto diferentes esquemas para realizar la
puntuación, los cuales se describen a continuación:

* OriginalScore: 
    * Es el esquema actual, se inicia con 100 puntos.
    * No se bonifican las letras correctas.
    * Se penaliza con 10 puntos con cada letra incorrecta.
    * El puntaje minimo es 0.

* BonusScore: 
    * El juego inicia en 0 puntos.
    * Se bonifica con 10 puntos cada letra correcta.
    * Se penaliza con 5 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    
* PowerBonusScore:
    * El juego inicia en 0 puntos.
    * La $i-ésima$ letra correcta se bonifica con $5^i$.
    * Se penaliza con 8 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    * Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es
      500.

Lo anterior, se traduce en el siguiente modelo, donde se aplica el
principio de inversión de dependencias:


![](img/model.png)


### Parte I

1. Clone el proyecto (no lo descargue!).
![image](https://user-images.githubusercontent.com/89365336/222550462-81eae12d-05fd-4b8e-94ea-dd3644fa0d5c.png)

   
2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.
Clases en el hangman.model:
![image](https://user-images.githubusercontent.com/89365336/222552397-dddcaae1-0e12-40fb-ae5d-b38d03b60b1c.png)

Interface GameScore:
```
package hangman.model;

public interface GameScore {
	public int calculateScore(int correctCount, int incorrectCount);
}
```

OriginalScore:
```
package hangman.model;

public class OriginalScore implements GameScore{

	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
```

BonusScore:
```
package hangman.model;

public class BonusScore implements GameScore{

	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
```

PowerBonusScore:
```
package hangman.model;

public class PowerBonusScore implements GameScore{

	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
```

3. Haga la especificación de los métodos calculateScore (de las tres
   variantes de GameScore), a partir de las especificaciones
   generales dadas anteriormente. Recuerde tener en cuenta: @pre,
   @pos, @param, @throws.
   
OriginalScore:
```
	/**
	 * This method calculates the final score according with the rules of OrginalScore
	 * The correct letters don´t add points, wrong letters remain 5 points
	 * @param correctCount total of right letters
	 * @param incorrectCount total of wrong letters
	 * @pre initialScore = 100
	 * @pos finalScore >= 0
	 * @return int finalScore total of points after discount wrong letters
	 */
```

BonusScore:
```
	/**
	 * This method calculates the final score according with the rules of BonusScore
	 * The correct letters add 10 points, wrong letters remain 5 points
	 * @param correctCount total of right letters
	 * @param incorrectCount total of wrong letters
	 * @pre initialScore = 0
	 * @pos finalScore >= 0
	 * @return total of points after discount wrong letters
	 */
```

PowerBonusScore:
```
	/**
	 * This method calculates the final score according with the rules of PowerBonusScore
	 * The correct i letter add 5^i points, wrong letters remain 8 points
	 * @param correctCount total of right letters
	 * @param incorrectCount total of wrong letters
	 * @pre initialScore = 0
	 * @pos finalScore >= 0
	 * @pos finalScore <= 500
	 * @return total of points after discount wrong letters
	 */
```

4. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "especificación métodos"
	```
![image](https://user-images.githubusercontent.com/89365336/222557408-d704ba03-6b39-4965-b993-87a240cd1500.png)


5. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8 .
Revisar pom.xml
![image](https://user-images.githubusercontent.com/89365336/222559211-fb8a121b-9292-4107-b3ee-7c3b7f6b4ce7.png)


6. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera. 
   
```
	/**
	 * 1- Equivalence Class: negative parameters, border condition(-1)
	 * 2- Equivalence Class: normal parameters (0-27), border condition(1)
	 * 3- Equivalence Class: large parameters (>27), border condition(1000)
	 */  

```

7. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.
   
OriginalScoreTest:
```
 private GameScore score = new OriginalScore();
	
	@Test
	public void ShouldThrowsExceptionWhenAnyParameterIsNegative() {
		//arrange
		String expectedResult = new ModelException("NEGATIVE_COUNTER").getMessage();
		int correctCount = 0;
		int incorrectCount = -1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);
		} catch (ModelException e) {
			//assert
			assertEquals(expectedResult, e.getMessage());
		}

	}

	@Test
	public void ShouldReturnPositiveResultWhenParametersAreValid() {
		//arrange
		int expectedResult = 90;
		int correctCount = 0;
		int incorrectCount = 1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnZeroWhenParametersAreLonger() {
		//arrange
		int expectedResult = 0;
		int correctCount = 0;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}
```

BonusScoreTest:
```
private GameScore score = new BonusScore();
	
	@Test
	public void ShouldThrowsExceptionWhenAnyParameterIsNegative() {
		//arrange
		String expectedResult = new ModelException("NEGATIVE_COUNTER").getMessage();
		int correctCount = 0;
		int incorrectCount = -1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);
		} catch (ModelException e) {
			//assert
			assertEquals(expectedResult, e.getMessage());
		}

	}

	@Test
	public void ShouldReturnFiveWhenBothParametersAreOne(){
		//arrange
		int expectedResult = 5;
		int correctCount = 1;
		int incorrectCount = 1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}

	}

	@Test
	public void ShouldReturnTenThousandWhenCorrectIs1000AndIncorrectIs0(){
		//arrange
		int expectedResult = 10000;
		int correctCount = 1000;
		int incorrectCount = 0;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
		
	}

	@Test
	public void ShouldReturnZeroWhenCorrectIs0AndIncorrectIs1000(){
		//arrange
		int expectedResult = 0;
		int correctCount = 0;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
		
	}

	@Test
	public void ShouldReturnFiveThousandWhenCorrectIs1000AndIncorrectIs1000(){
		//arrange
		int expectedResult = 5000;
		int correctCount = 1000;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
		
	}
```

PowerBonusTest:
```
private GameScore score = new PowerBonusScore();

	@Test
	public void ShouldThrowsExceptionWhenAnyParameterIsNegative() {
		//arrange
		String expectedResult = new ModelException("NEGATIVE_COUNTER").getMessage();
		int correctCount = 0;
		int incorrectCount = -1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);
		} catch (ModelException e) {
			//assert
			assertEquals(expectedResult, e.getMessage());
		}

	}

	@Test
	public void ShouldReturnZeroWhenBothParametersAreOne() {
		//arrange
		int expectedResult = 0;
		int correctCount = 1;
		int incorrectCount = 1;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnFiveHundredWhenCorrectIs1000AndIncorrectIs0() {
		//arrange
		int expectedResult = 500;
		int correctCount = 1000;
		int incorrectCount = 0;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnZeroWhenCorrectIs0AndIncorrectIs1000() {
		//arrange
		int expectedResult = 0;
		int correctCount = 0;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}

	@Test
	public void ShouldReturnFiveHundredWhenCorrectIs1000AndIncorrectIs1000() {
		//arrange
		int expectedResult = 500;
		int correctCount = 1000;
		int incorrectCount = 1000;

		//action
		try {
			int result = score.calculateScore(correctCount, incorrectCount);

			//assert
			assertEquals(expectedResult, result);
		} catch (ModelException e) {
			assertEquals(true, false);
		}
	}
```

8. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "implementación pruebas"
	```
![image](https://user-images.githubusercontent.com/89365336/222591387-e2e70086-3a0f-475d-ae0b-527206a697de.png)


9. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.

OriginalScore.calculateScore():
```
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws ModelException{

		if(correctCount < 0 || incorrectCount <0){
			throw new ModelException("NEGATIVE_COUNTER");
		}

		int score = 100;
		int badScore = incorrectCount*10;
		int finalScore = score - badScore;
		finalScore = finalScore > 0 ? finalScore : 0;
		return finalScore;

	}
```

BonusScore.calculateScore():
```
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws ModelException{

		if(correctCount < 0 || incorrectCount <0){
			throw new ModelException("NEGATIVE_COUNTER");
		}

		int score = 0;
		int goodScore = correctCount*10;
		int badScore = incorrectCount*5;
		int finalScore = score + goodScore - badScore;
		finalScore = finalScore > 0 ? finalScore : 0;
		return finalScore;
		
	}
```

PowerBonusScore.calculateScore():
```
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws ModelException{
		if(correctCount < 0 || incorrectCount <0){
			throw new ModelException("NEGATIVE_COUNTER");
		}

		int score = 0;
		int goodScore = calculateBonus(correctCount);
		int badScore = incorrectCount*8;
		int finalScore = score + goodScore - badScore;
		finalScore = finalScore < 500 ? finalScore : 500;
		finalScore = finalScore > 0 ? finalScore : 0;
		return finalScore;
		
	}

	private int calculateBonus(int correctCount) {
		int bonus = 0;
		for(int i = 1; i <= correctCount; i++) {
			bonus += 5^i;
		}
		return bonus;
	}
```

![image](https://user-images.githubusercontent.com/89365336/222594423-88b9ac09-e3e0-4db2-9719-e3e7a510ae8d.png)


10. Al finalizar haga un nuevo commit:

	```bash		
	git add .			
	git commit -m "implementación del modelo"
	```
![image](https://user-images.githubusercontent.com/89365336/222594775-c036b57f-94fe-47e6-8cbc-24f9b619bd75.png)


11. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

```bash	
	git push <URL Repositorio>	
```

![image](https://user-images.githubusercontent.com/89365336/222596309-35650fdc-6b89-4178-9f06-27f89b4a54fc.png)


### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar createGUIUsingFactoryMethod en SwingProject, el
constructor de la clase GUI y HangmanFactoryMethod).

En este taller se va a utilizar un contenedor liviano ([GoogleGuice](https://github.com/google/guice)) el cual soporta la inyección de las dependencias.

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

Incorpore el Contenedor Liviano Guice dentro del proyecto:

* Revise las dependencias necesarias en el pom.xml.
* Modifique la inyección de dependencias utilizando guice en lugar del
  método fábrica..
* Configure la aplicación de manera que desde el programa SwingProject
  NO SE CONSTRUYA el Score directamente, sino a través de Guice, asi
  mismo como las otras dependencias que se están inyectando mediante
  la fabrica.
* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
	* Utilizar el esquema OriginalScore.
	* Utilizar el esquema BonusScore.
	* Utilizar el idioma francés.
    * Utilizar el diccionario francés.
	* etc...
* Para lo anterior, [puede basarse en el ejemplo dado como
  referencia](https://github.com/PDSW-ECI/LightweighContainers_DepenendecyInjectionIntro-WordProcessor).
