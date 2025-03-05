# 개발자 환경 구축 / 깃&깃허브 내용 정리


### git 명령어
git 전역설정
git config --global user.email : 유저이메일
git config --global user.name : 닉네임
git config --global --list : 확인

git 명령어
git init			: 초기파일 생성

git add 			: 파일 스테이징

git commit 		: 파일 커밋
-m 			: 메세지

git reset 			: 되돌리기
--hard			: 돌아간 커밋 이후의 변경 이력을 전부 삭제
--soft			: 변경 이력 삭제, 변경 내용은 남아있음, 인덱스 초기화(git add가 안되어 있는 상태)
--mixed			: 변경 이력 삭제, 변경 내용은 남이있음, 인덱스도 유지(git add까지 되어 있음)

git status 		: git의 현재상태
git log --oneline 		: 확인 명령어
git reflog			: 로그확인

git branch 브랜치명	: 브랜치 생성
git checkout 브랜치명	: 브랜치 이동
git switch 브랜치명

git merge		: 병합 (병합시 병합하는 브랜치에서 작업)
--continue		: 병합 이어하기

git push origin		: 깃허브에 푸쉬

git clone (URL)		: 깃허브에서 파일 가져오기

head : 현재작업중인 브랜치를 가리키는 파일
config : 저장소 설정 정보를 가지는 파일
hooks : git에서 발생하는 이벤트에 대해 자동으로 실행하는 스크립트 파일을 담고 있는 폴더

!  git에서의 작업을 github로 연동시킬땐 readme파일을 생성하면안됨
!! 작업을 할땐 브랜치를 따로 주고 작업해야함(충돌문제)
- - -  
### git flow
