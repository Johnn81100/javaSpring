FROM php:8.1-apache

COPY --from=composer:2 /usr/bin/composer /usr/bin/composer
RUN composer --version && php -v
RUN apt-get update && apt-get upgrade -y && apt-get -y install sudo
RUN docker-php-ext-install pdo pdo_mysql
RUN docker-php-ext-install mysqli && docker-php-ext-enable mysqli
RUN apt install -y libzip-dev && docker-php-ext-install zip
RUN apt-get install git nano -y
RUN rm /root/.bashrc
RUN curl -o /root/.bashrc https://gist.githubusercontent.com/marioBonales/1637696/raw/93a33aa5f1893f46773483250214f8b8b496a270/.bashrc
RUN ln -s /etc/apache2/mods-available/rewrite.load /etc/apache2/mods-enabled
