> yadon079.github.io님 모방학습입니다.   


클래스와 객체차이
---
> 많은 사람들이 클래스와 객체의 차이로 인해 혼란스러워합니다.   
차이점은 간단하고 개념적입니다. 클래스는 객체의 템플릿입니다.  
클래스는 유효한 값 범위와 기본값을 포함하는 객체 속성을 정의합니다.  
클래스는 또한 객체 동작을 설명합니다.  
객체는 클래스의 멤버 또는 "인스턴스"입니다.  


클래스와 객체
---
### 클래스 정의와 용도
클래스란 '객체를 정의해놓은 것' 또는 '객체의 설계도'라고 정의할 수 있다.  
클래스는 객체를 생성하는데 사용되며, 객체는 클래스에 정의된 대로 생성된다.

- 정의  
> 클래스란 객체를 정의해 놓은 것이다.   
- 용도  
> 클래스는 객체를 생성하는데 사용된다.

### 객체의 정의와 용도
객체의 사전적 정의는 '실제로 존재하는 것'이다. 우리 주변의 사물들이 곧 객체이다.  
객체지향이론에서는 사물과 같은 유형적인 것 뿐만 아니라, 개념이나 논리와 같은 무형적인  
것들도 객체로 간주한다.

프로그래밍에서의 객체는 클래스에 정의된 내용대로 메모리에 생성된 것을 뜻한다.

- 정의  
실제로 존재하는 것. 사물 또는 개념   
* 용도  
객체가 가지고 있는 기능과 속성에 따라 다름

### 클래스 정의와 관계
클래스와 객체의 관계는 제품 설계도와 제품의 관계라고 할 수 있다.  
클래스는 객체를 생성하는데 사용될 뿐, 객체 그 자체는 아니다. 원하는 기능의 객체를  
사용하기 위해서는 클래스로부터 객체를 생성하는 것이 먼저이다.

클래스를 정의하고 클래스를 통해 객체를 생성하는 이유는 설계도를 통해서 제품을 만드는  
이유와 같다. 하나의 설계도를 잘 만들어 놓으면 제품을 만드는 일이 쉬워지기 때문이다.

JDK에서는 프로그래밍을 위해 많은 수의 유용한 클래스(Java API)를 기본적으로 제공하고 있으며,  
이 클래스들을 이용해서 원하는 기능의 프로그램을 보다 쉽게 작성할 수 있다.

### 객체와 인스턴스

클래스로부터 객체를 만드는 과정을 클래스의 <b>'인스턴스화(instantiate)'</b>라고 하며,  
어떤 클래스로부터 만들어진 객체를 그 클래스의 <b>'인스턴스(instance)'</b>라고 한다.

인스턴스는 객체와 같은 의미이지만, 객체는 모든 인스턴스를 대표하는 포괄적인 의미를 가지고 있으며,  
인스턴스는 어떤 클래스로부터 만들어진 것인지를 강조하는 보다 구체적인 의미를 가지고 있다.

### 객체의 구성요소 - 속성과 기능

객체는 속성과 기능, 두 종류의 구성요소로 이루어져 있으며, 일반적으로 객체는 다수의 속성과 다수의 기능을 갖는다.  
즉, 객체는 속성과 기능의 집합이라고 할 수 있다. 객체가 가지고 있는 속성과 기능을 그 객체의  
<b>멤버(구성원, member)</b>라 한다.

클래스는 객체를 정의한 것이므로 클래스에는 객체의 모든 속성과 기능이 정의되어 있다.  
클래스로부터 객체를 생성하면, 클래스에 정의된 속성과 기능을 가진 객체가 만들어지는 것이다.  
속성과 기능은 같은 뜻의 여러 용어가 있다.

