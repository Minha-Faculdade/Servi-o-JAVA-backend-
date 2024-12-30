Este trabalho foi realizado em três etapas, sendo que cada etapa corresponde a um
projeto Spring (Sistema Back-End), não sendo necessário implementar nenhuma interface
gráfica.
Objetivo: Consultar o nome do cliente passando como parâmetro o código do cliente e
retorne em formato JSON o código e nome do cliente.

1) Criando um projeto Spring Boot cliente
   Acesse o site do Projeto Spring em: https://spring.io/
- Na opção Projects selecione Spring Initializr
2) Altere a versão do Spring Framework no arquivo pom.xml:
<version>2.2.5.RELEASE</vers
3) Configure o arquivo application.properties, adicione a linha abaixo:
server.port = 8081
4) Crie no pacote.modelo uma classe Java Cliente, os atributos serão id (Long) ,
nome (String) e cpf (String), crie um construtor com os atributos e os métodos
getters e setters.
Obs: obrigatório a implementação da classe com estes atributos e tipos.
5) Crie no pacote controle uma classe que será o controlador somente o método
buscarCliente usando como requisição o GET.
6) localize no projeto a classe main Trabalho2Application, clique na classe com o
botão direito do mouse → Run As → Java Application e deixe a aplicação
rodando.
7) No ambiente virtual está disponível um tutorial de como utilizar o Postman para
testar o nosso backend, no AVEA na disciplina LP4 localize a aba Tutoriais e siga o
arquivo Tutorial Uso do Postman.
Obs: Teste usando a url abaixo:
http://localhost:8081/clientes/1
8) Verifique se ao enviar a url o controle do produto retorna o JSON com o id e
nome do cliente.

ETAPA 2 - PROJETO SPRING CPF
Objetivo: Consultar o cpf do cliente passando como parâmetro o código do cliente e
retorne em formato JSON o código, nome e cpf do cliente.
OBS: Fazer a msm coisa da ETAPA 1 só que agora é CPF o nome


ETAPA 3 - PROJETO SERVIÇO CLIENTECPF

Objetivo: Consultar o cpf e o nome do cliente passando como parâmetro o código do
cliente e retorne em formato JSON o código, nome e cpf do cliente.

17)Criando um projeto Spring Boot clientecpf
Obs: No ambiente virtual está disponível um tutorial de como criar um projeto Spring Boot
e como importar para o Eclipse. No AVEA na disciplina LP4 localize a aba Tutoriais e siga
o arquivo TUTORIAL CRIAÇÃO PROJETO SPRING E IMPORTAÇÃO NO ECLIPSE.
Obs: Só selecione as bibliotecas utilizadas nos projetos de referência.

18)Altere a versão do Spring Framework no arquivo pom.xml:
<version>2.2.5.RELEASE</version>

19)Configure o arquivo application.properties, adicione a linha abaixo:
server.port = 8083

20)Crie no pacote.modelo uma classe Java ClienteCPF, os atributos serão id (Long)
, nome (String) e cpf (String), crie um construtor com os atributos e os métodos
getters e setters.
Obs: obrigatório a implementação da classe com estes atributos e tipos.

21)Crie no pacote controle uma classe que será o controlador somente o método
buscarClienteComCPF usando como requisição o GET, porém, este método deve
acessar os WEBClient implementado na classe Service (referência projeto
consumer) e estes deverão retornar o JSON com o id, nome e cpf do cliente
para o método invocado no controller.

22)localize no projeto a classe main Trabalho2Application, clique na classe com o
botão direito do mouse → Run As → Java Application e deixe a aplicação
rodando.

23)No ambiente virtual está disponível um tutorial de como utilizar o Postman para
testar o nosso backend, no AVEA na disciplina LP4 localize a aba Tutoriais e siga o
arquivo Tutorial Uso do Postman.
Obs: Teste usando a url abaixo:
http://localhost:8083/cliente/1/cpf
