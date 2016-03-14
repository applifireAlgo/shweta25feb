




echo $PATH
DB_PATH=/tmp/applifire/db/XCOJWNQ9AKKXTOZFW23IG/868647B2-0D2E-4D64-980E-53657AECF5D5
MYSQL=/usr/bin
USER=spro
PASSWORD=spro
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'