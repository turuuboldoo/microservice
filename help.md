# Spring boot in Kotlin using PostgreSQL and Docker

Энэхүү заавар нь Spring boot framework-г Kotlin хэл дээр ашиглах demo. Мөн хөгжүүлэлтийн орчин бэлтгэх заавар нь Ubuntu дээр байгаа болно.

## OpenJDK суулгах
```
sudo apt update
sudo apt install openjdk-11-jdk
```

Амжилттай суусан бол Java version шалгана уу
```
java -version
```

## Gradle суулгах
Gradle вэбсайтруу орж хамгийн сүүлийн хувилбарыг шалган VERSION хувьсагчийн утгыг өөрчлөн ашиглаарай.  
[https://gradle.org/releases/](https://gradle.org/releases/)

```
VERSION=7.5
wget https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip -P /tmp
```

Таталт амжилттай болсон бол */opt/gradle* directory-д zip file-г задлана.

```
sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
```

Unzip үед алдаа гарсан бол Unzip package суулгаарай.

```
sudo apt install unzip
```

Environment Variables зарлах

```
export GRADLE_HOME=/opt/gradle/latest
export PATH=${GRADLE_HOME}/bin:${PATH}
```

Gradle суулгах явц амжилттай бол version шалгаад үзээрэй

```
gradle -v
```

## Docker

Эхлээд танд Docker Engine хэрэг болно. Үндсэн бэвсайтаас заавартай танилцах бол  
[Docker Engine суулгах заавар](https://docs.docker.com/engine/install/ubuntu/)
[Docker Desktop суулгах заавар](https://docs.docker.com/desktop/install/ubuntu/)

Update apt package
```
sudo apt-get update
sudo apt-get install \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
```

Add Docker’s official GPG key

```
sudo mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
```

Use the following command to set up the repository
```
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

Install Docker Engine
```
sudo apt update -y
sudo apt install docker-ce docker-ce-cli containerd.io docker-compose-plugin -y
```

_apt update_ үед алдаа гарч байвал дараах командыг ажлуулан дахин _sudo apt update -y_ хийнэ үү
```
sudo chmod a+r /etc/apt/keyrings/docker.gpg.
```

Install docker and docker compose
```
sudo apt install docker
sudo apt install docker-compose
```
Docker service ассан эсэхээ шалгаарай
```
sudo systemctl status docker
```
```
Output
● docker.service - Docker Application Container Engine
     Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
     Active: active (running) since Tue 2020-05-19 17:00:41 UTC; 17s ago
TriggeredBy: ● docker.socket
       Docs: https://docs.docker.com
   Main PID: 24321 (dockerd)
      Tasks: 8
     Memory: 46.4M
     CGroup: /system.slice/docker.service
             └─24321 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
```

## IntelliJ IDEA Community
Kotlin хэлний албан ёсны үнэгүй IDE суулгаарай

```
sudo snap install intellij-idea-community --classic
```

## NodeJS
```
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt-get install -y nodejs
```

## Git
Git суулгах
```
sudo apt install git -y
```
Repository clone хийх
```
git clone git@github.com:turuuboldoo/spring-in-kotlin.git
```

Git clone хийх үед _ssh_ алдаа гарч байвал _ssh key_ нэмэх шаардлагатай [SSH key үүсгэх](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

## Хөгжүүлэлт
Project хуулсан directory-руу очин docker орсноос асаах

```
docker-compose up -d --build
```

Амжилттай ассан эсэхээ шалгах
```
docker-compose ps
```

Docker орчноос зөвхөн PostgreSQL асааж байгаа тул та IDE дээрээс RUN хийх эсвэл terminal 
дээрээс <mark style="background-color: #FFF">gradle run</mark> командаар project асаах боломжтой. 
/ Энэ нь зөвхөн local орчны тохиргоо болно/

Postman folder дотор байгаа collection file-р api endpoint туршиж үзээрэй
