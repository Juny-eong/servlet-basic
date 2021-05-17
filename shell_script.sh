#!/bin/bash

# touch shell_script.sh : 파일 생성
# chmod +x shell_script.sh : 실행권한 부여

# echo : 자동 개행
echo "Echo test"

# printf : 자동 개행X
printf "printf test"

# %s : 뒤에 오는 문자열을 인자로 전달
echo "%s %s" Echo Test

# $0 : 실행하는 스크립트의 파일명 (실행 시 경로를 포함했다면 경로를 포함해서 출력)
echo "Name of Script: %s" $0

# $1, $2, ... : 스크립트로 수행 시 전달받은 인자들
# $# : 스크립트에 전달되는 인자의 수
echo "[%d] arguments test %s %s" $# $1 $2

# 변수 선언
# [=]를 이용해서 선언하고 [$]를 이용해서 사용
# [=]는 공백없이 붙여 써야한다.
# 지역변수에는 [local]을 붙인다.
# {} 는 parameter expansion으로 [$]와 함께 감싼 부분에 변수를 대입해준다. 

test="abc"
num=100

echo ${test}
echo ${num}
echo "${test}"
echo "${num}"

# local 변수는 함수 내에서만 사용 가능하다.
# local local_val="local one"

# 변수가 선언되지 않았을 때 default_value=${default_value:="example default value"} 와 같은 식으로
# 기본값을 사용하도록 설정 가능
default_value=${default_value:="example default value"}

test=1234
echo "This is ${test}5678"

# 함수 선언
function func(){

	a=10
	b=5

	if [ ${a} -eq ${b} ]; then
		echo "a는 b와 같다."
	fi

	if [ ${a} -ne ${b} ]; then
		echo "a와 b는 같지 않다."
	fi

}

# 함수 호출
func


# 조건문
# if [ 값1 조건 값2 ]; then
# 	... 작업 내용 ...
# fi
#
# -eq : ==	-gt : >		-lt : <
# -ne : !=	-ge : >=	-le : <=		
#
# 파일 관련 조건
# if[ -d ${var} ]; then		--> ${var}의 디렉토리가 존재하면 참이 성립
# if[ -e ${var} ]; then		--> ${var}라는 파일이 존재하면 참이 성립
# if[ -s ${var} ]; then		--> ${var}라는 파일의 크기가 0보다 크면 참이 성립
# -r : 읽을 수 있으면 참	-w : 쓸 수 있으면 참
# -x : 실행할 수 있으면 참	-f : 정규 파일이면 참
# -c : 문자 장치이면 참

# AND / OR 조건
function func_(){
	a=aa
	b=bb

	if [ -f ${a} -a -d ${b} ]; then
		echo "a는 파일, b는 디렉토리"
	elif [ ! -f ${a} -o -d ${b} ]; then
		echo "elif test"
	fi
}
func_


# 반복문

function func1(){
	echo "사용 예1"
	for i in 1 2 3 4 5
	do
		echo "${i}"
	done

	echo "사용 예2"
	list="1 2 3 4 5"
	for i in ${list}
	do
		echo "${i}"
	done

	echo "사용 예3 : 1부터 5까지 출력"
	for i in {1..5}
	do
		echo "${i}"
	done

	echo "사용 예4 : 크기를 2만큼 증가시키면서 출력"
	for i in {1..5..2}
	do
		echo "${i}"
	done

	echo "사용 예5 : 배열을 이용"
	arr=(1 2 3 4 5)
	for i in "${arr[@]}"
	do
		echo "${i}"
	done

	echo "시용 예6 : C와 유사한 형식의 for 문"
	for ((i=0; i<5; i++)); do
		echo "${i}"
	done
}

func1
