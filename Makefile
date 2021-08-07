.PHONY: all req_txt

all: req_txt

req_txt:
	@echo "exporting to requirement.txt"
	@poetry export -f requirements.txt --output requirements.txt