android-challenge-05-14
=======================
Repositório para armazenamento dos resultados da atividade de Android do LIS em Maio de 2014

Setup do ambiente:
=======================
- Instalar o Android Studio
- Instalar o Genymotion
- Instalar plugin do Genymotion para o Android Studio
- Baixar o emulador do Nexus 5 no Genymotion
- Criar um projeto de Android
- Iniciar o emulador do Nexus 5
- Rodar a aplicação no emulador, ver o resultado


Tarefas:
=======================
- Realizar o processo de setup e visualziar a app de sample no emulador
- A tela principal deve conter:
  - 3 botões que serão usadas para navegar para cada uma das tarefas
- O primeiro botão deve navegar para uma nova tela que deve conter:
  - Um campo de texto que pergunta o nome do usuário com um botão para confirmar
  - Abaixo, uma mensagem que dá olá para o último nome inserido
  - Ao preencher o campo e apertar Ok, este valor deve ser salvo no sistema para que na próxima execução seja buscado e escrito na mensagem
- O segundo botão deve navegar para uma nova tela que deve conter:
  - A partir do arquivo "data.txt", criar uma lista de todos os nomes compostos na lista
  - Ao tocar em um dos itens da lista, abrir nova tela com os detalhes completos da pessoa, mostrando a foto e o nome e cargo ao lado (Picasso library)
