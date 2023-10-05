#!/bin/zsh
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

docker cp "$SCRIPT_DIR/../../testset/." sdd_jedis_postgres:/docker-entrypoint-initdb.d/
docker exec -it sdd_jedis_postgres bash -c 'su postgres -c "psql --file=/docker-entrypoint-initdb.d/coverage/database.sql"'