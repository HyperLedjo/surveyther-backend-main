# Surveyther-Backend-Main Project

이더리움 기반의 서베이 거래 플랫폼의 개발용 저장소입니다.   
적용 대상은 Spring Boot 기반 웹 백엔드 파트입니다.

## Our team

- 김한결 (Backend Developer, Team Leader)
- 양성희 (Frontend Developer)
- 박병규 (Solidity Developer) 
- 김소망 (Technical Writer)

## Requirements

STS 4   
SpringBoot 2.5.4   

# 프로젝트 개요

## 프로젝트 제목
블록체인 기반 서베이 데이터 거래 플랫폼 '서베이더'

## 프로젝트 작업 기간
2021년 9월 ~ 10월 초 : 기획 및 설계
2021년 10월 ~ 10월 말 : 
    
## 개발 배경
- 많은 시간과 비용 지출
- 데이터 조작 가능성
- 어려운 집계 결과
- 위 세가지 사항에 대한 해결

## 서비스 목표
- 신뢰성 : 블록체인 기반으로 데이터 위변조 방지
- 접근성 : 누구나 가입 절차 없이 서비스 이용
- 참여 유도 : 확실한 보상과 소비 경로 확보로 일반인 참여율 높임
- 전문성 : 전문적인 설문 양식을 제공해 누구나 신뢰할 수 있는 설문 가능
- 과정 최소화 : 설문을 등록, 진행, 집계하는 과정 최소화
- 통계 시각화 : 설문 결과를 시각화하여 데이터를 한 눈에 요약 및 인사이트 제공
- 비용 절감 : 타 플랫폼보다 저렴한 비용으로 설문 등록 및 거래
- 수익성 : 목표를 성공적으로 달성한 설문 결과를 판매하여 수익 창출

## 서비스 주요 고객
- 사업가 및 연구원
- 일반인

# 기술 스택
## 프론트 엔드
- VueJS
- ChartJS
- BootStrap

## 백엔드
- Spring Boot
- Web3J
- Web3J-CLI
- Kakao Login/Logout API
- I'm Port 결제 모듈 API

## 블록체인
- Ethereum
- Ganache

## 클라우드
- AWS EC2
- Oracle Cloud VM Instance

## 데이터베이스
- MySQL

# 서비스 아키텍쳐
1. Layer

<img src="https://user-images.githubusercontent.com/67471629/140270506-b19dc641-4589-4e19-80d2-b7a9ac58fcc8.png" alt="서비스 레이어"/>

2. Structure

<img src="https://user-images.githubusercontent.com/67471629/140270522-c4d96d6c-cfa1-474a-8390-760650f5612b.png" alt="서비스 구조도"/>


# 핵심 기능
1. 서베이 등록 및 결제 프로세스
2. 서베이 참여 및 보상 지급 프로세스
3. 서베이 마감 프로세스
4. 서베이 구매 및 결제 프로세스
5. 컨트랙트 대리자 서비스    
<img src="https://user-images.githubusercontent.com/67471629/140270412-fb9df1cb-e6ef-4f60-bd4a-811a54461890.png" alt="대리자 서비스"/>
