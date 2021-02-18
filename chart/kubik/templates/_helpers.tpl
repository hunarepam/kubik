{{/* kubik application label */}}
{{- define "kubik.app.labels"}}
labels:
  app: kubik
{{- end }}


{{/*database application label*/}}
{{- define "kubik.db.labels"}}
labels:
  app: postgres
{{- end }}

{{/*database environment configuration*/}}
{{- define "kubik.env"}}
env:
  - name: POSTGRES_USER
    valueFrom:
      configMapKeyRef:
        name: db-config
        key: postgres_user
  - name: POSTGRES_PASSWORD
    valueFrom:
      configMapKeyRef:
        name: db-config
        key: postgres_password
  - name: POSTGRES_DB
    valueFrom:
      configMapKeyRef:
        name: db-config
        key: postgres_db_name
  - name: PGDATA
    value: /var/lib/postgresql/data/pgdata
{{- end }}